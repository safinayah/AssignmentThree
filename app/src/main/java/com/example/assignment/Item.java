package com.example.assignment;

public class Item {
    public Item() {
    }

        private String name;
        private String contents;
        private int imageID;

    public Item(String name, String contents, int imageID) {
        this.name = name;
        this.contents = contents;
        this.imageID = imageID;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public static final Item[] menu = {
            new Item("Quinoa Salad","Rocket, Carrots,Black Olive, " +
                    "Corn, White Cabbage, Quinoa, Cranberry, Red Onion, Cherryy Tomato, Sunflower Seed, Honey Mustard Sauce",R.drawable.qsalad),
            new Item("Sunrise Salad", "Lettuce, Cucumber, Cherry Tomato, Broccoli, Mushroom, Purpule Onions, Boiled Egg, Turkey, Low Fat Cheese, Avocado," +
                    " Sunflower Seeds, Lemon Sauce", R.drawable.sunrisesalad),
            new Item("Smoked Salmon Sandwich","Smoked Salmon, Tomato, Purple Onion, Avocado, Lettuce, Mushroom, Lemon, Vinigrette",R.drawable.sandwich)


    };


        public String getName(){
         return name;
        }


        public String getContents(){
        return contents;
        }


}


