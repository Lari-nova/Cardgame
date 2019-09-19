package com.example.cardgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.cardgame.Entity.CardGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private ImageView cardToGuess;
    private ImageView cardOne;
    private ImageView cardTwo;
    private ImageView cardThree;
    private ImageView cardFour;
    private ImageView cardFive;
    private Button restartButton;
    private List<CardGame> cardGameList = new ArrayList<>();
    private int idGuess;
    private boolean isGameComplete = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_actitvity);
        initializationComponent();
        createListeners();
        createCardContent();
        startGame();
    }

    @Override
    protected void onDestroy() {
        finish();
        System.exit(0);
        super.onDestroy();
    }

    private void initializationComponent() {
        cardToGuess = findViewById(R.id.card_to_guess);
        cardOne = findViewById(R.id.card_one);
        cardTwo = findViewById(R.id.card_two);
        cardThree = findViewById(R.id.card_three);
        cardFour = findViewById(R.id.card_four);
        cardFive = findViewById(R.id.card_five);
        restartButton = findViewById(R.id.restart_button);
    }

    private void createListeners() {
        cardOne.setOnClickListener((View view) -> {
            if (!isGameComplete) userSelect(0, cardOne);
        });
        cardTwo.setOnClickListener((View view) -> {
            if (!isGameComplete)  userSelect(1, cardTwo);
        });
        cardThree.setOnClickListener((View view) -> {
            if (!isGameComplete) userSelect(2, cardThree);
        });
        cardFour.setOnClickListener((View view) -> {
            if (!isGameComplete) userSelect(3, cardFour);
        });
        cardFive.setOnClickListener((View view) -> {
            if (!isGameComplete) userSelect(4, cardFive);
        });

        restartButton.setOnClickListener((View view) -> {
            restartGame();
            startGame();
        });
    }
    private void userSelect(int id, ImageView imageView) {
        CardGame selectCard = cardGameList.get(id);
        int cardId = selectCard.getCardId();
        imageView.setImageResource(cardId);
        if (cardId == idGuess) Toast.makeText(this, "Win", Toast.LENGTH_LONG).show();
        else Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
        isGameComplete = true;
    }

    private void createCardContent() {
        CardGame oneCard = new CardGame();
        oneCard.setCardId(R.drawable.durak);
        cardGameList.add(oneCard);
        CardGame twoCard = new CardGame();
        twoCard.setCardId(R.drawable.dyavol);
        cardGameList.add(twoCard);
        CardGame threeCard = new CardGame();
        threeCard.setCardId(R.drawable.imperator);
        cardGameList.add(threeCard);
        CardGame fourCard = new CardGame();
        fourCard.setCardId(R.drawable.imperatrica);
        cardGameList.add(fourCard);
        CardGame fiveCard = new CardGame();
        fiveCard.setCardId(R.drawable.smert);
        cardGameList.add(fiveCard);
    }

    private void startGame() {
        idGuess = cardGameList.get(0).getCardId();
        cardToGuess.setImageResource(idGuess);
    }

    private void restartGame() {
        Collections.shuffle(cardGameList);
        cardOne.setImageResource(R.drawable.rubashka);
        cardTwo.setImageResource(R.drawable.rubashka);
        cardThree.setImageResource(R.drawable.rubashka);
        cardFour.setImageResource(R.drawable.rubashka);
        cardFive.setImageResource(R.drawable.rubashka);
        isGameComplete = false;
    }
}
