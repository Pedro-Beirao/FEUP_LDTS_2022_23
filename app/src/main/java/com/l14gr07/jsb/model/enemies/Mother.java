package com.l14gr07.jsb.model.enemies;

import java.io.IOException;
import java.net.URISyntaxException;

import com.l14gr07.jsb.Loader;
import com.l14gr07.jsb.model.Enemy;

public class Mother extends Enemy
{
    public Mother(int npx1, int npy1) throws IOException, URISyntaxException
    {
        super(npx1, npy1, npx1, npy1, false, 0, Loader.get_string_from_file("enemies/mother.txt"), 12, 16);
    }
}
