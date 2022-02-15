package com.bridgelabz.Day7;

import java.util.Random;

public class GamblingSimulator {
    public static final int STAKE_PER_DAY = 100;
    public static final int BET_PER_GAME = 1;
    public static final int WIN = 1;
    public static int stake = 0;
    static int daysWonCount = 0;
    static int daysLostCount = 0;

    public static void winCheck() {
        Random random = new Random();
        int betReturns = random.nextInt(2);
        if (betReturns == WIN) {
            stake++;// incrementing
        } else {
            stake--;// decrementing
        }

    }

    public static void resignDayCheck() {
        int totalStake = 0;
        stake = 0;
        while (stake != 50 && stake != -50) {
            winCheck();
        }
        totalStake = stake + STAKE_PER_DAY;
        System.out.println("Total stake for resign for a day is  " + totalStake);

    }

    public static void monthlyWinOrLossCheck() {
        int day;
        for (day = 1; day <= 20; day++) {
            System.out.printf("day %d\n", day);
            resignDayCheck();
            if (stake == 50) {
                daysWonCount++;
            } else if (stake == -50) {
                daysLostCount++;
            }
        }
        System.out.printf("days won for a month = %d\ndays lost for a month = %d\n", daysWonCount, daysLostCount);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Simulation");
        monthlyWinOrLossCheck();
    }
}
