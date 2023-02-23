package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import java.util.Random;

import android.widget.ImageView;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** これ以降のメソッドを追加 **/
    // グーが押された時のイベント
    public void onClickRock(View view) {
        game(0);
    }
    // チョキーが押された時のイベント
    public void onClickScissors(View view) {
        game(1);
    }
    // パーが押された時のイベント
    public void onClickPaper(View view) {
        game(2);
    }
    /**
     * コンピューターの手をランデムに決定し、勝敗の判定を行う
     * @param playerHand  0:グー、1:チョキ、2:パー
     */
    private void game(int playerHand) {
        String[] handTexts = { "グー", "チョキ", "パー" };
        String[] handimage = { "guu", "tyoki", "paa" };

        // ランダムクラスで、０以上、３未満の乱数を生成して
        // コンピュータの手をランダムに決定
        Random r = new Random();
        int cupHand = r.nextInt(3);
        String judge = null;
        // プレイヤーとコンピュータの手を比較して勝敗を判定する
        if (playerHand == cupHand) {
            judge = "あいこ";
        } else if (playerHand == 0 && cupHand == 2) {
            // 「グー」対「パー」
            judge = "まけ";
        } else if (playerHand == 0 && cupHand == 1) {
            // 「グー」対「チョキ」
            judge = "かち";
        } else if (playerHand == 1 && cupHand == 0) {
            // 「チョキ」対「グー」
            judge = "まけ";
        } else if (playerHand == 1 && cupHand == 2) {
            // 「チョキ」対「パー」
            judge = "かち";
        } else if (playerHand == 2 && cupHand == 0) {
            // 「パー」対「グー」
            judge = "かち";
        } else if (playerHand == 2 && cupHand == 1) {
            // 「パー」対「チョキ」
            judge = "まけ";
        }
        // コンピューターの手および、勝敗の判定結果を画面に表示
        TextView textViewJudge = (TextView)findViewById(R.id.judge);
        textViewJudge.setText(judge);
        TextView textViewCpu = (TextView)findViewById(R.id.cpu);
        textViewCpu.setText(handTexts[cupHand]);
        ImageView ImageViewhand = (ImageView) findViewById(R.id.hand);
        String texta = handimage[cupHand];
        ImageViewhand.setImageResource(getResources().getIdentifier(texta, "drawable", getPackageName()));



    }

}