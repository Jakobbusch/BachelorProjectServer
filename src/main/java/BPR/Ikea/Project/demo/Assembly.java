package BPR.Ikea.Project.demo;

import java.util.ArrayList;

public class Assembly {

    private int iD;
    private String webGL;
    private int buildTime;
    private int buildDifficulty;
    private ArrayList<Instruction> instructions;

    /**
     * Constructor for Assembly
     * @param iD
     * @param webGL
     * @param buildTime
     * @param buildDifficulty
     * @param instructions
     */
    public Assembly(int iD, String webGL, int buildTime, int buildDifficulty, ArrayList<Instruction> instructions) {
        this.iD = iD;
        this.webGL = webGL;
        this.buildTime = buildTime;
        this.buildDifficulty = buildDifficulty;
        this.instructions = instructions;
    }

    /**
     * To get id
     * @return iD
     */
    public int getiD() {
        return iD;
    }

    /**
     * To set id
     * @param iD
     */
    public void setiD(int iD) {
        this.iD = iD;
    }

    /**
     * To get webGL link
     * @return webGL
     */
    public String getWebGL() {
        return webGL;
    }

    /**
     * To set webGL link
     * @param webGL
     */
    public void setWebGL(String webGL) {
        this.webGL = webGL;
    }

    /**
     * To get build time
     * @return buildtime
     */
    public int getBuildTime() {
        return buildTime;
    }

    /**
     * To set build time
     * @param buildTime
     */
    public void setBuildTime(int buildTime) {
        this.buildTime = buildTime;
    }

    /**
     * To get build difficulty
     * @return buildDifficulty
     */
    public int getBuildDifficulty() {
        return buildDifficulty;
    }

    /**
     * To set build difficulty
     * @param buildDifficulty
     */
    public void setBuildDifficulty(int buildDifficulty) {
        this.buildDifficulty = buildDifficulty;
    }

    /**
     * To get list of instructions
     * @return instructions
     */
    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    /**
     * To set list of instructions
     * @param instructions
     */
    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }
}
