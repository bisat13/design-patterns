package patterns.behavioral.momento;

public class MomentoPatternDemo {

  public static void main(String[] args) {
    TextEditor textEditor = new TextEditor();
    EditorHistory editorHistory = new EditorHistory();

    textEditor.setText("Hello");
    System.out.println("Current Text:" + textEditor.getText());
    editorHistory.saveState(textEditor.save());

    textEditor.setText("Hello, World!");
    System.out.println("Current text: " + textEditor.getText());
    editorHistory.saveState(textEditor.save());

    textEditor.setText("Hello, World! Welcome to Memento Pattern.");
    System.out.println("Current text: " + textEditor.getText());

    Momento previousState  = editorHistory.undo(textEditor.save());
    textEditor.restore(previousState);
    System.out.println("After undo, text: " + textEditor.getText());

    previousState = editorHistory.undo(textEditor.save());
    textEditor.restore(previousState);
    System.out.println("After second undo, text: " + textEditor.getText());

    previousState = editorHistory.redo(textEditor.save());
    textEditor.restore(previousState);
    System.out.println("After first redo, text: " + textEditor.getText());
  }
}
