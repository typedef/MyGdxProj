package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;



/**
 * Created with IntelliJ IDEA.
 * User: zouying
 * Date: 13-1-31
 * Time: 下午10:00
 * To change this template use File | Settings | File Templates.
 */
public class Animator implements ApplicationListener {

    private static  final int FRAME_COLS = 6;
    private static  final int FRAME_ROWS = 5;

    private Animation walkAnimator;
    private Texture     walkSheet;
    private TextureRegion[]  walkFrame;
    private TextureRegion   currentFrame;
    private SpriteBatch     batch;

    private OrthographicCamera camera;
    private Sprite sprite;

    private  float statTime;

    @Override
    public void create() {
       walkSheet = new Texture(Gdx.files.internal("data/animation_sheet.png"));
       TextureRegion[][]  temp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS,
                    walkSheet.getHeight()/FRAME_ROWS) ;
       walkFrame = new TextureRegion[FRAME_ROWS * FRAME_COLS];

        int index=0;
        for(int i = 0; i < FRAME_COLS; i++)
            for (int j=0; j < FRAME_ROWS;j++)
                walkFrame[index++] = temp[j][i];
        walkAnimator = new Animation(0.05f, walkFrame);
        batch = new SpriteBatch();
        statTime = 0;
    }

    @Override
    public void dispose() {
        batch.dispose();
        walkSheet.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);                                            // #14
        statTime += Gdx.graphics.getDeltaTime();                       // #15

        currentFrame = walkAnimator.getKeyFrame(statTime, true);
        batch.begin();
        batch.draw(currentFrame,256,256);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
