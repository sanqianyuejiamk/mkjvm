package mengka.btrace_05;

import com.mengka.common.TimeUtil;
import java.util.Date;

/**
 * User: mengka.hyy
 * Date: 14-9-13-обнГ7:21
 */
public class Mengka {

    public String baicai(String taa) {
        taa = taa + "_#baicai#_[" + TimeUtil.toDate(new Date(), TimeUtil.format_1) + "]";
        return taa;
    }

    public String qingcai(String taa){
        taa = taa + "_#qingcai#_[" + TimeUtil.toDate(new Date(), TimeUtil.format_1) + "]";
        return taa;
    }


    public String xigua(String taa){
        taa = taa + "_#xigua#_[" + TimeUtil.toDate(new Date(), TimeUtil.format_1) + "]";
        return taa;
    }
}
