package com.lucianapuccinelli.jogomemoria

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var jogo: Jogo
    private lateinit var cardViews: List<ImageView>
    private lateinit var cardImagens: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botaoRestart = findViewById<Button>(R.id.botaoRestart)
        botaoRestart.setOnClickListener {
            restartGame()
        }


        cardImagens = listOf(
            R.drawable.card_1, R.drawable.card_2, R.drawable.card_3, R.drawable.card_4, R.drawable.card_5, R.drawable.card_6, R.drawable.card_7, R.drawable.card_8,
            R.drawable.card_1, R.drawable.card_2, R.drawable.card_3, R.drawable.card_4, R.drawable.card_5, R.drawable.card_6, R.drawable.card_7, R.drawable.card_8
        )

        cardViews = listOf(
            findViewById(R.id.card0), findViewById(R.id.card1), findViewById(R.id.card2), findViewById(R.id.card3),
            findViewById(R.id.card4), findViewById(R.id.card5), findViewById(R.id.card6), findViewById(R.id.card7),
            findViewById(R.id.card8), findViewById(R.id.card9), findViewById(R.id.card10), findViewById(R.id.card11),
            findViewById(R.id.card12), findViewById(R.id.card13), findViewById(R.id.card14), findViewById(R.id.card15)
        )

        jogo = Jogo(cardImagens)

        for (cardView in cardViews) {
            cardView.setOnClickListener(this)
        }
    }

    private fun restartGame() {
        jogo = Jogo(cardImagens)
        updateUI()
    }

    override fun onClick(view: View) {
        val position = cardViews.indexOf(view)
        if (jogo.virarCarta(position)) {
            updateUI()
        }
    }

    private fun updateUI() {
        for ((index, card) in jogo.cartas.withIndex()) {
            val cardView = cardViews[index]
            if (card.isVirada) {
                cardView.setImageResource(card.getImagemId())
            } else {
                cardView.setImageResource(R.drawable.card_bg)
            }
        }
    }

}
