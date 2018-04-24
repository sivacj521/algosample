package com.alayam.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Tanvi on 9/3/2017.
 */
public class ParticleAnimation {

    public String[] animate(int speed, String init) {
        //Will take in String initial state and speed.
        //eg: 2, "..R...."
//        "..X....",
//        "....X..",
//        "......X",
//        "......."}


        //Lets make particle list
        char[] chars = init.toCharArray();
        List<Particle> particleList = new ArrayList<>();
        for(int i=0; i<chars.length ; i++ ){
            if(chars[i] == 'L') {
                particleList.add(new Particle(i,'L'));
            }else if(chars[i] == 'R') {
                particleList.add(new Particle(i,'R'));
            }
        }

        List<String> particleState = new ArrayList<>();

        while(!particleList.isEmpty()) {
            String currentState = getCurrentState(init, particleList);
            particleState.add(currentState);
            advanceParticleToNextPosition(particleList, speed, init.length());
        }


        String result[] = new String[particleState.size()];

        particleState.toArray(result);
        return result;
    }

    private void advanceParticleToNextPosition(List<Particle> particleList, int speed, int containerSize) {
        Iterator<Particle> iter = particleList.iterator();
        while(iter.hasNext()) {
            Particle particle = iter.next();
            particle.move(speed);
            if(particle.getPosition() >= containerSize || particle.getPosition() < 0)
                iter.remove();
        }
    }

    private String getCurrentState(String init, List<Particle> particleList) {
        char[] currentState = new char[init.length()];
        for(int i =0 ;i< currentState.length; i++ ){
            currentState[i] = '.';
        }

        Iterator<Particle> iterator = particleList.iterator();
        while(iterator.hasNext()){
            Particle particle = iterator.next();
            currentState[particle.getPosition()] = 'X';
        }

        return new String(currentState);
    }

    class Particle{
        int position;
        char direction; //L left R right

        public Particle(int position, char direction) {
            this.position = position;
            this.direction = direction;
        }

        void move(int speed){
            if(direction == 'L') position = position - speed;
            else if(direction == 'R') position = position + speed;
        }

        public int getPosition() {
            return position;
        }

        public char getDirection() {
            return direction;
        }
    }

    public static void main(String args[]){

        String inStr[] = {"..R....",
                "RR..LRL",
                "LRLR.LRLR",
                "RLRLRLRLRL",
                "...",
                "LRRL.LR.LRR.R.LRRL."};
        int speed[] ={2,3,2,10,1,1};
        ParticleAnimation p = new ParticleAnimation();
        for(int i=0; i<inStr.length; i++){
            System.out.println("----------------------------");
            System.out.println("speed "+speed[i] + "str "+inStr[i]);
            String res[] = p.animate(speed[i], inStr[i]);
            for(String s: res){
                System.out.println(s);
            }
        }
    }
}
