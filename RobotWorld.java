import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta es la clase que contiene el mundo de juego de RobotWorld.
 * 
 * @author Diego Prieto 
 * @version 03/03/2020
 */
public class RobotWorld extends World
{

    /**
     * Constructor for objects of class RobotWorld.
     * 
     */
    public RobotWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new Robot(),48,50);
        
        int[][] array = { {52,147},{159, 147},{266,147}};
        
        for(int i = 0; i< array.length; i++){
            addObject(new Wall(),array[i][0],array[i][1]);
        }
        
        addObject(new Wall(),587,147);
        addObject(new Wall(),692,147);
        addObject(new Wall(),791,147);       
        
        addObject(new Block(),427,145);       
        addObject(new Home(),751,552);       
        addObject(new ScorePanel(),71,554);       
                                
        addObject(new Pizza(),720,46);       
        addObject(new Pizza(),443,38);       
        addObject(new Pizza(),183,302);       
        addObject(new Pizza(),682,312);       
        addObject(new Pizza(),417,537);       
                                        
    }
}
