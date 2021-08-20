public class Worker {
    private OnTaskDoneList callBack;
    private OnTaskErrorListener errorCallBack;

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    public Worker(OnTaskDoneList callBack, OnTaskErrorListener errorCallBack) {
        this.callBack = callBack;
        this.errorCallBack = errorCallBack;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i + 1 == 33) {
                errorCallBack.onError("Task " + (i + 1) + " error");
            }
            callBack.onDone("Task " + (i + 1) + " is done");
        }
    }
}
