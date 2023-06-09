package Valuator;

/**
 *
 * @author ondre
 */
public class GrahamsFormulas {
    private final CentralObject central;
    
    public GrahamsFormulas(CentralObject central){
        this.central = central;
    }
    /**
     *
     * @return
     */
    public double grahamsSummary(){
        double grah = graham();
        double grahRev = grahamReversed();
        double diff1 = central.getActualPrice()/grah;
        double diff2 = central.getActualPrice()/grahRev;
        if(diff1 > 1 && diff2 > 1){
            if(diff1 > diff2){return grahRev;}else{return grah;}
        }else{if(diff1 < 1 && diff2 < 1){
            if(diff1 > diff2){return grah;}else{return grahRev;}
        }}
        if(diff1 > 1 && diff2 < 1){
            diff1 --;
            if(diff1 > diff2){return grahRev;}else{return grah;}
        }else{
            if(diff1 < 1 && diff2 > 1){
                diff2 --;
                if(diff1 > diff2){return grahRev;}else{return grah;}
            }else{
                if(diff1 == 1){return grah;}else{return grahRev;}
            }
        }
    }
    /**
     *
     * @return
     */
    public double grahamMoS(){
        return graham() - graham() * central.getMarginOfSafety();
    }
    /**
     *
     * @return
     */
    public double grahamRevMoS(){
        return grahamReversed() - grahamReversed() * central.getMarginOfSafety();
    }
    /**
     *
     * @return
     */
    public double graham(){
        if(central.getEarningsPerShare() == 0){
            return 0;
        }else{
            if(central.getGrowthRate() == 0){
                return 0;
            }else{
                if(central.getAAACurrentYield() == 0){
                    return 0;
                }else{
                    return (central.getEarningsPerShare() * ((2 * central.getGrowthRate()) + 8.5) * 4.4) / central.getAAACurrentYield();
                }
            }
        }
    }
    /**
     *
     * @return
     */
    public double grahamReversed(){
        if(central.getEarningsPerShare() == 0) {
            return 0;
        } else {
            if(central.getGrowthRate() == 0) {
                return 0;
            } else {
                if (central.getAAACurrentYield() == 0) {
                    return 0;
                } else {
                    return (central.getEarningsPerShare() * ((1 * central.getGrowthRate()) + 7) * 4.4) / central.getAAACurrentYield();
                }
            }
        }
    }
}
