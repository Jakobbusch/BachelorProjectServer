package BPR.Ikea.Project.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "varTest",
        "intTest",

})
public class TestClass {

    @JsonProperty("varTest")
        private String varTest;

    @JsonProperty("intTest")
        private int intTest;



    public TestClass(String varTest, int intTest){
        this.varTest = varTest;
        this.intTest = intTest;
    }
    @JsonProperty("varTest")
    public String getVarTest() {
        return varTest;
    }
    @JsonProperty("varTest")
    public void setVarTest(String varTest) {
        this.varTest = varTest;
    }
    @JsonProperty("intTest")
    public int getIntTest() {
        return intTest;
    }
    @JsonProperty("intTest")
    public void setIntTest(int intTest) {
        this.intTest = intTest;
    }
}
