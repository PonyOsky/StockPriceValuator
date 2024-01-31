package Valuator;

/**
 *
 * @author ondre
 */
public class GrahamsFormulas {

    private double value;
    private double valueMoS;
    private double valueRev;
    private double valueRevMoS;

    /**
     *
     * @param actPrice
     * @return
     */
    public double grahamsSummary(double actPrice) {
        double diff1 = actPrice / value;
        double diff2 = actPrice / valueRev;
        if (diff1 > 1 && diff2 > 1) {
            if (diff1 > diff2) {
                return valueRev;
            } else {
                return value;
            }
        } else {
            if (diff1 < 1 && diff2 < 1) {
                if (diff1 > diff2) {
                    return value;
                } else {
                    return valueRev;
                }
            }
        }
        if (diff1 > 1 && diff2 < 1) {
            diff1--;
            if (diff1 > diff2) {
                return valueRev;
            } else {
                return value;
            }
        } else {
            if (diff1 < 1 && diff2 > 1) {
                diff2--;
                if (diff1 > diff2) {
                    return valueRev;
                } else {
                    return value;
                }
            } else {
                if (diff1 == 1) {
                    return value;
                } else {
                    return valueRev;
                }
            }
        }
    }

    /**
     *
     * @param actPrice
     * @return
     */
    public double grahamsSummaryMoS(double actPrice) {
        double diff1 = actPrice / valueMoS;
        double diff2 = actPrice / valueRevMoS;
        if (diff1 > 1 && diff2 > 1) {
            if (diff1 > diff2) {
                return valueRevMoS;
            } else {
                return valueMoS;
            }
        } else {
            if (diff1 < 1 && diff2 < 1) {
                if (diff1 > diff2) {
                    return valueMoS;
                } else {
                    return valueRevMoS;
                }
            }
        }
        if (diff1 > 1 && diff2 < 1) {
            diff1--;
            if (diff1 > diff2) {
                return valueRevMoS;
            } else {
                return valueMoS;
            }
        } else {
            if (diff1 < 1 && diff2 > 1) {
                diff2--;
                if (diff1 > diff2) {
                    return valueRevMoS;
                } else {
                    return valueMoS;
                }
            } else {
                if (diff1 == 1) {
                    return valueMoS;
                } else {
                    return valueRevMoS;
                }
            }
        }
    }

    /**
     *
     * @param pillow
     */
    public void grahamMoS(double pillow) {
        valueMoS = value - value * pillow;
    }

    /**
     *
     * @param pillow
     */
    public void grahamRevMoS(double pillow) {
        valueRevMoS = valueRev - valueRev * pillow;
    }

    /**
     *
     * @param eps
     * @param grRate
     * @param y
     */
    public void graham(double eps, double grRate, double y) {
        if (eps != 0 || grRate != 0 || y != 0) {
            value = (eps * ((2 * grRate) + 8.5) * 4.4) / y;
        } else {
            value = 0;
        }
    }

    /**
     *
     * @param eps
     * @param grRate
     * @param y
     */
    public void grahamReversed(double eps, double grRate, double y) {
        if (eps != 0 || grRate != 0 || y != 0) {
            valueRev = (eps * ((1 * grRate) + 7) * 4.4) / y;
        } else {
            valueRev = 0;
        }
    }

    /**
     *
     * @return
     */
    public double getValue() {
        return value;
    }

    /**
     *
     * @return
     */
    public double getValueRev() {
        return valueRev;
    }

    /**
     *
     * @return
     */
    public double getValueMoS() {
        return valueMoS;
    }

    /**
     *
     * @return
     */
    public double getValueRevMoS() {
        return valueRevMoS;
    }

}
