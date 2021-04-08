import generated_files.tiny_parserBaseVisitor;
import generated_files.tiny_parserParser;

import java.util.ArrayList;
import java.util.Stack;

import nodes.*;


public class Routines extends tiny_parserBaseVisitor<Node>{

    private ArrayList<String> semanticErrors;

    public Routines() {
        this.semanticErrors = new ArrayList<>();
    }
}
