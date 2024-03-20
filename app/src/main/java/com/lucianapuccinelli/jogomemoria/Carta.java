package com.lucianapuccinelli.jogomemoria;

public class Carta {
    private int imagemId;
    private boolean isVirada;

    public Carta(int imageId) {
        this.imagemId = imageId;
        this.isVirada = false;
    }

    public void setImagemId(int imagemId) {
        this.imagemId = imagemId;
    }
    public void setVirada(boolean virada) {
        isVirada = virada;
    }

    public int getImagemId() {
        return imagemId;
    }

    public boolean isVirada() {
        return isVirada;
    }

}

