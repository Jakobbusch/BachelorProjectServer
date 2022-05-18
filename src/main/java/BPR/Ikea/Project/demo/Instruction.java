package BPR.Ikea.Project.demo;

public class Instruction {

    private int instructionID;
    private int instructionStepNumber;
    private String instructionText;

    public Instruction(int instructionID, int instructionStepNumber, String instructionText) {
        this.instructionID = instructionID;
        this.instructionStepNumber = instructionStepNumber;
        this.instructionText = instructionText;
    }

    public int getInstructionID() {
        return instructionID;
    }

    public void setInstructionID(int instructionID) {
        this.instructionID = instructionID;
    }

    public int getInstructionStepNumber() {
        return instructionStepNumber;
    }

    public void setInstructionStepNumber(int instructionStepNumber) {
        this.instructionStepNumber = instructionStepNumber;
    }

    public String getInstructionText() {
        return instructionText;
    }

    public void setInstructionText(String instructionText) {
        this.instructionText = instructionText;
    }
}
