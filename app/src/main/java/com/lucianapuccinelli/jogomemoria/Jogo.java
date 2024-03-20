package com.lucianapuccinelli.jogomemoria;

import android.os.Handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogo {
    private List<Carta> cartas;
    private List<Carta> cartasViradas;
    private boolean canFlip;
    private int paresCertos;

    public List<Carta> getCartas() {
        return cartas;
    }

    public List<Carta> getCartasViradas() {
        return cartasViradas;
    }

    public boolean isCanFlip() {
        return canFlip;
    }

    public int getParesCertos() {
        return paresCertos;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public void setCartasViradas(List<Carta> cartasViradas) {
        this.cartasViradas = cartasViradas;
    }

    public void setCanFlip(boolean canFlip) {
        this.canFlip = canFlip;
    }

    public void setParesCertos(int paresCertos) {
        this.paresCertos = paresCertos;
    }

    public Jogo(List<Integer> imagemCard) {
        this.cartas = new ArrayList<>();
        this.cartasViradas = new ArrayList<>();
        this.canFlip = true;
        this.paresCertos = 0;
        iniciarJogo(imagemCard);
    }

    private void iniciarJogo(List<Integer> imagemCard) {
        List<Integer> imagemEmba = new ArrayList<>(imagemCard);
        Collections.shuffle(imagemEmba);
        for (Integer imageId : imagemEmba) {
            cartas.add(new Carta(imageId));
        }
    }

    public boolean virarCarta(int position) {
        if (canFlip) {
            Carta carta = cartas.get(position);
            if (!carta.isVirada()) {
                carta.setVirada(true);
                cartasViradas.add(carta);
                if (cartasViradas.size() == 2) {
                    canFlip = false;
                    identificar();
                }
                return true;
            }
        }
        return false;
    }

    private void identificar() {
        if (cartasViradas.get(0).getImagemId() == cartasViradas.get(1).getImagemId()) {
            paresCertos++;
            cartasViradas.clear();
            canFlip = true;
        } else {
            Handler handler = new Handler();
            handler.postDelayed(() -> {
                for (Carta cartaVirada : cartasViradas) {
                    cartaVirada.setVirada(false);
                }
                cartasViradas.clear();
                canFlip = true;
            }, 1000);
        }
    }

}
