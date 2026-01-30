package patterns.behavioral.chainOfResponsibility;

public class Director extends Approver {
  @Override
  public void processLeaveRequest(int leaveDays) {
    if (leaveDays <= 14) {
      System.out.println("Director approved the leave.");
    } else if (nextApprover != null) {
      nextApprover.processLeaveRequest(leaveDays);
    } else {
      System.out.println("Leave request denied. Too many days!");
    }
  }
}
