package BPR.Ikea.Project.demo;

import java.util.ArrayList;

public class Assembly {

    private int assemblyID;
    private String assemblyWebGL;
    private int assemblyBuildTime;
    private int assemblyBuildDifficulty;
    private ArrayList<Instruction> assemblyInstructions;

    public Assembly(int assemblyID, String assemblyWebGL, int assemblyBuildTime, int assemblyBuildDifficulty, ArrayList<Instruction> assemblyInstructions) {
        this.assemblyID = assemblyID;
        this.assemblyWebGL = assemblyWebGL;
        this.assemblyBuildTime = assemblyBuildTime;
        this.assemblyBuildDifficulty = assemblyBuildDifficulty;
        this.assemblyInstructions = assemblyInstructions;
    }

    public int getAssemblyID() {
        return assemblyID;
    }

    public void setAssemblyID(int assemblyID) {
        this.assemblyID = assemblyID;
    }

    public String getAssemblyWebGL() {
        return assemblyWebGL;
    }

    public void setAssemblyWebGL(String assemblyWebGL) {
        this.assemblyWebGL = assemblyWebGL;
    }

    public int getAssemblyBuildTime() {
        return assemblyBuildTime;
    }

    public void setAssemblyBuildTime(int assemblyBuildTime) {
        this.assemblyBuildTime = assemblyBuildTime;
    }

    public int getAssemblyBuildDifficulty() {
        return assemblyBuildDifficulty;
    }

    public void setAssemblyBuildDifficulty(int assemblyBuildDifficulty) {
        this.assemblyBuildDifficulty = assemblyBuildDifficulty;
    }

    public ArrayList<Instruction> getAssemblyInstructions() {
        return assemblyInstructions;
    }

    public void setAssemblyInstructions(ArrayList<Instruction> assemblyInstructions) {
        this.assemblyInstructions = assemblyInstructions;
    }
}
