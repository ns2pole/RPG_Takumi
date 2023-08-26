package com.example.rpg.Calc.save;
import com.example.rpg.Calc.Game;
import com.example.rpg.Calc.Item.Item;
import com.example.rpg.Calc.Item.Ship;
import com.example.rpg.Calc.Monsters.MetalSlime;

import java.io.*;

public class SaveWriteAndRead {
    public Game game;
    public SaveWriteAndRead(Game game){
        this.game = game;
    }
    public void write(){
        try (FileOutputStream file = new FileOutputStream("C:\\Users\\2009t\\IdeaProjects\\ex001\\src\\save.dat");
             BufferedOutputStream buffered = new BufferedOutputStream(file);
             ObjectOutputStream output = new ObjectOutputStream(buffered);){
            output.reset();
            output.writeObject(game);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Game read(){
        try (FileInputStream file = new FileInputStream("C:\\Users\\2009t\\IdeaProjects\\ex001\\src\\save.dat");
             BufferedInputStream buffered = new BufferedInputStream(file);
             ObjectInputStream input = new ObjectInputStream(buffered)){
            this.game = (Game) input.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return game;
    }
}
