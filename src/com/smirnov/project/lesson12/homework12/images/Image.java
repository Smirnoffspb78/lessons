package com.smirnov.project.lesson12.homework12.images;


public class Image implements Drawable, Cloneable {
    private String path;

    public Image(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public void draw() {
        System.out.println(path);
    }

    @Override
    public String toString() {
        return "Image{path='%s'}".formatted(path);
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public Image clone() {
        try {
            return (Image) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }
}
