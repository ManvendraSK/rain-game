package com.manvendrask.rain.graphics;

import java.util.Arrays;
import java.util.Random;

public class Screen {
    private int width, height;
    public int[] pixels;
    public int MAP_SIZE = 8;
    public int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width * height];

        for (int i = 1; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[0] = 0x000000;
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    public void clear() {
        Arrays.fill(pixels, 0);
    }

    public void render(int xOffset, int yOffset) {
        for (int y = 0; y < height; y++) {
            int yy = y + yOffset;

            for (int x = 0; x < width; x++) {
                int xx = x + xOffset;

                int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) +
                        ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;

                pixels[x + (y * width)] = tiles[tileIndex];
            }
        }
    }
}
