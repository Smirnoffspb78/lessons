package com.smirnov.project.lesson12.homework12.images;


import java.util.Arrays;

public class Gallery implements Drawable {
    private String name;
    private Drawable[] drawables;

    public Gallery(String name, Drawable[] drawables) {
        this.drawables = drawables;
        this.name = name;
    }

    @Override
    public Gallery clone() {
        Drawable[] drawablesCopy = new Drawable[drawables.length];
        Gallery gallery = new Gallery(getName(), drawablesCopy);
        for (int i = 0; i < drawablesCopy.length; i++) {
            if (drawables[i] instanceof Image) {
                gallery.drawables[i] = ((Image) drawables[i]).clone();
            } else if (drawables[i] instanceof Gallery) {
                gallery.drawables[i] = ((Gallery) drawables[i]).clone();
            }
        }
        return gallery;
    }

    public Drawable[] getDrawables() {
        return drawables;
    }

    public Drawable[] getImages() {
        return drawables;
    }

    @Override
    public void draw() {
        System.out.println(name);
        for (Drawable drawable : drawables) {
            drawable.draw();
        }
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDrawables(Drawable[] drawables) {
        this.drawables = drawables;
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "name='" + name + '\'' +
                ", drawables=" + Arrays.toString(drawables) +
                '}';
    }

}
