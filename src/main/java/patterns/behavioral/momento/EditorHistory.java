package patterns.behavioral.momento;

import java.util.Stack;

public class EditorHistory {

  public Stack<Momento> undoStack = new Stack<>();
  public Stack<Momento> redoStack = new Stack<>();
  public void saveState(Momento momento) {
    undoStack.push(momento);
    redoStack.clear();
  }

  public Momento undo(Momento currentState) {
    if (!undoStack.isEmpty()) {
      redoStack.push(currentState);
      return undoStack.pop();
    }
    return null;
  }

  public Momento redo(Momento currentState) {
    if (!redoStack.isEmpty()) {
      undoStack.push(currentState);
      return redoStack.pop();
    }
    return null;
  }
}
