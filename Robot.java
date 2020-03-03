import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class Robot here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Robot extends Actor
    {
        /** Variables para animar el robot*/
        private GreenfootImage robotImage1;
        private GreenfootImage robotImage2;
        private int lives;
        private int score;
        private int pizzaEaten;
        
        /**
         * Constructor para el Robot
         */
        public Robot(){
            robotImage1 = new GreenfootImage("man01.png");
            robotImage2 = new GreenfootImage("man02.png");    
            
            lives = 3;
            score = 0;
            pizzaEaten = 0;
        }
        
        /**
         * Act - do whatever the Robot wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        public void act() 
        {
            robotMovement();
            detectWallCollision();
            detectBlockCollision();
            eatPizza();
            detectHome();
            animate();
        }    
        
        /**
         * En este método vamos a mover el Robot.
         */
        public void robotMovement()
        {
            if(Greenfoot.isKeyDown("right"))
            {
                setLocation(getX() + 3, getY());
            } 
            if(Greenfoot.isKeyDown("left"))
            {
                setLocation(getX() - 3, getY());
            } 
            if(Greenfoot.isKeyDown("down"))
            {
                setLocation(getX(), getY() + 3);
            } 
            if(Greenfoot.isKeyDown("up"))
            {
                setLocation(getX(), getY() - 3);
            } 
            
        }
        
        /**
         * Detectar si mi robot se choco con un muro.
         */
        public void detectWallCollision()
        {
            if(isTouching(Wall.class))
            {
                Greenfoot.playSound("hurt.wav");
                setLocation(48,50);
                removeLife();
            }
        }
        
        /**
         * Detectar si mi robot se choco con un bloque.
         */
        public void detectBlockCollision()
        {
            if(isTouching(Block.class))
            {
                Greenfoot.playSound("hurt.wav");
                setLocation(48,50);
                removeLife();
            }
        }
        
        public void removeLife()
        {
            lives--;
            if(lives <= 0){
                Greenfoot.stop();
            }
            showStatus();            
        }
        
        public void increaseScore(){
            score++;
            showStatus();
        }
        
        public void detectHome()
        {
            if(isTouching(Home.class) && pizzaEaten == 5)
            {
                Greenfoot.playSound("yipee.wav");
                setLocation(48,50);
                pizzaEaten = 0;
                increaseScore();
            }
        }
        
        public void showStatus(){
            getWorld().showText("Lives : " + lives, 70, 540);
            getWorld().showText("Score : " + score, 70, 560);            
        }
        
        public void eatPizza()
        {
            if(isTouching(Pizza.class))
            {
                Greenfoot.playSound("eat.wav");
                removeTouching(Pizza.class);              
                pizzaEaten++;
            }
        }
                
        public void animate() {
            if(getImage() == robotImage1){
                setImage(robotImage2);
            }else{
                setImage(robotImage1);
            }
        }
}
