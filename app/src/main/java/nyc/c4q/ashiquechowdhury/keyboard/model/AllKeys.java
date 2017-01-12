package nyc.c4q.ashiquechowdhury.keyboard.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ashiquechowdhury on 1/11/17.
 */

public class AllKeys {
    boolean success;
    @SerializedName("available keys") List<Keys> availablekeys;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Keys> getAvailablekeys() {
        return availablekeys;
    }

    public void setAvailablekeys(List<Keys> availablekeys) {
        this.availablekeys = availablekeys;
    }
}
