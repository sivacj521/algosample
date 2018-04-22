package com.alayam.locks;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class ReadWriteLockSiva {

    private Multiset<Thread> readingThreads = HashMultiset.create();

    private int writeAccesses    = 0;
    private int writeRequests    = 0;
    private Thread writingThread = null;

    public synchronized void lockRead() throws InterruptedException{
        Thread callingThread = Thread.currentThread();
        while(! canGrantReadAccess(callingThread)){
            wait();
        }
        readingThreads.add(callingThread);
    }

    public synchronized void unlockRead(){
        Thread callingThread = Thread.currentThread();
        if(!isReader(callingThread)){
            throw new IllegalMonitorStateException("Calling Thread does not" +
                    " hold a read lock on this ReadWriteLock");
        }
        readingThreads.remove(callingThread);
        notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException{
        writeRequests++;
        Thread callingThread = Thread.currentThread();
        while(! canGrantWriteAccess(callingThread)){
            wait();
        }
        writeRequests--;
        writeAccesses++;
        writingThread = callingThread;
    }

    public synchronized void unlockWrite() throws InterruptedException{
        if(!isWriter(Thread.currentThread())){
            throw new IllegalMonitorStateException("Calling Thread does not" +
                    " hold the write lock on this ReadWriteLock");
        }
        writeAccesses--;
        if(writeAccesses == 0){
            writingThread = null;
        }
        notifyAll();
    }

    private boolean canGrantReadAccess(Thread callingThread){
        if( isWriter(callingThread) ) return true;
        if( hasWriter()             ) return false;
        if( isReader(callingThread) ) return true;
        if( hasWriteRequests()      ) return false;
        return true;
    }

    private boolean canGrantWriteAccess(Thread callingThread){
        if(isOnlyReader(callingThread))    return true;
        if(hasReaders())                   return false;
        if(writingThread == null)          return true;
        if(!isWriter(callingThread))       return false;
        return true;
    }

    private boolean hasReaders(){
        return readingThreads.size() > 0;
    }

    private boolean isReader(Thread callingThread){

        return readingThreads.contains(callingThread) ;
    }

    private boolean isOnlyReader(Thread callingThread){
        return readingThreads.count(callingThread)== 1 ;
    }

    private boolean hasWriter(){
        return writingThread != null;
    }

    private boolean isWriter(Thread callingThread){
        return writingThread == callingThread;
    }

    private boolean hasWriteRequests(){
        return this.writeRequests > 0;
    }

}