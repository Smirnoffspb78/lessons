package com.smirnov.project.lesson12.homework12;


/*import com.company.project.lesson11.task.images.Drawable;
import com.company.project.lesson11.task.images.Editor;
import com.company.project.lesson11.task.images.Gallery;
import com.company.project.lesson11.task.images.Image;*/


import com.smirnov.project.lesson12.homework12.images.Drawable;
import com.smirnov.project.lesson12.homework12.images.Editor;
import com.smirnov.project.lesson12.homework12.images.Gallery;
import com.smirnov.project.lesson12.homework12.images.Image;

public class Task11 {
    public static void main(String[] args) {
        Image treeImage = new Image("tree.png");
        Image grassImage = new Image("grass.png");
        Image lakeImage = new Image("lake.png");

        Image foxImage = new Image("fox.png");

        Image treeImageCopy = treeImage.clone();
        System.out.println("Копия до исправления: " + treeImageCopy);

        treeImageCopy.setPath("tree.png->newPath");

        System.out.println("Оригинал после исправления копии: " + treeImage);
        System.out.println("Копия: " + treeImageCopy);

        Drawable[] drawableReversed = new Drawable[]{lakeImage, grassImage, treeImage};

        System.out.println("\n\n\nGallery");

        Gallery forestGallery = new Gallery("Forest", new Drawable[]{treeImage, grassImage, lakeImage});
        Gallery forestGalleryCopy = forestGallery.clone();
        System.out.println("копия до исправления" + forestGalleryCopy);
        forestGalleryCopy.getDrawables()[0] = lakeImage;
        forestGalleryCopy.getDrawables()[2] = treeImage;

        forestGalleryCopy.setName("Forest->newName");
        /*forestGalleryCopy.setDrawables(drawableReversed);*/
        System.out.println("Оригинал после исправления копии:" + forestGallery);
        System.out.println("Копия: " + forestGalleryCopy);
        System.out.println("\n\n\nGallery in gellery");
        Gallery forestAndAnimalGallery = new Gallery("Forest and Animal", new Drawable[]{forestGallery, foxImage});
        Gallery forestAndAnimalGalleryCopy = forestAndAnimalGallery.clone();

        System.out.println("Оригинал до исправления : " + forestAndAnimalGallery);
        System.out.println("Копия до исправления: " + forestAndAnimalGalleryCopy);

        forestGalleryCopy.setName("Forest and Animal->newName");
        forestAndAnimalGalleryCopy.getDrawables()[0] = lakeImage;


        System.out.println("Оригинал: " + forestAndAnimalGallery);
        System.out.println("копия: " + forestAndAnimalGalleryCopy);


        System.out.println("\n\n\nEditor");
        Editor editor = new Editor(forestAndAnimalGallery);
        System.out.println("оригинал: " + editor);

        Editor editorCopy = editor.clone();
        System.out.println("копия до исправления" + editorCopy);
        editorCopy.setDrawable(treeImage);

        System.out.println("оригинал после исправления копии" + editor);
        System.out.println("Копия после исправления" + editorCopy);

        //Класс Editor содержит объекты, имплементирующие интерфейс Drawable
        //Объекты, имелементирующие интерфейс Drawable - Gallery и Image
        //Galery содержит name String и массив Drawable
        //Массив Drawable может содержать, как массивы, так и отдельные объекты Image


    }
}
