package academy.utils.constructs

class Looper {

    private long maxRuns

    private Closure code

    private long runs = 0

    static Looper loop(long maxRuns = 10_000, Closure code) {
        new Looper(maxRuns: maxRuns, code: code)
    }

    void until(Closure test) {
        runs++
        code(runs)
        while (!test() && runs < maxRuns) {
            runs++
            code(runs)
        }
        if (runs >= maxRuns) {
            throw new IllegalStateException("looper runs = $runs")
        }
    }

}
