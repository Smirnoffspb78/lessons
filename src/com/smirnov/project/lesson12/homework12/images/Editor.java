package com.smirnov.project.lesson12.homework12.images;

public final class Editor implements Cloneable {
    private Drawable drawable;

    public Editor(Drawable drawable) {
        setDrawable(drawable);
    }

    public void setDrawable(final Drawable drawable) {
        this.drawable = drawable;
    }

    public void show() {
        drawable.draw();
    }

    @Override
    public String toString() {
        return "Editor{drawable=%s}".formatted(drawable);
    }

    @Override
    public Editor clone() {
        if (drawable instanceof Image) {
            return new Editor(((Image) drawable).clone());
        } else {
            return new Editor(((Gallery) drawable).clone());
        }
    }


    public Drawable getDrawable() {
        return drawable;
    }
}
