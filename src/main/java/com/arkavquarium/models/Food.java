package com.arkavquarium.models;

public class Food implements Drawable {
    private static final String assetPath = "assets/img/food.png";
    private static final int PRICE = 10;
    /**
    * Max velocity of the food movement
    */
    private static int MAX_VELOCITY = 30;
    private Position position;
    /**
     * Construct Food at destined position
     * @param position position of food
     */
    public Food(Position position){
        this.position = new Position(position.getAbsis(), position.getOrdinate());
    }

    /**
     * Move Food to bottom
     * @param y minimum height
     * @param elapsedSeconds elapsed seconds
     */
    public void move(int y, double elapsedSeconds){
        Position bottom = new Position(0, y);
        this.position.moveVertical(bottom, elapsedSeconds * MAX_VELOCITY);
    }

    /**
    * @return food position 
    **/
    public Position getPosition(){
        return this.position;
    }

    /**
     * @return asset path
     */
    public String getAssetPath(){
        return assetPath;
    }

    /**
     * @return food price
     */
    public final int getPrice(){
        return PRICE;
    }
}