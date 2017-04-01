package MMN15;


/*
 * Decompiled with CFR 0_110.
 */
public class Time1 {
    private int _hour;
    private int _minute;
    private int _second;
    private final int MIN_HOUR = 0;
    private final int MIN_MINUTE = 0;
    private final int MIN_SECOND = 0;
    private final int MAX_HOUR = 23;
    private final int MAX_MINUTE = 59;
    private final int MAX_SECOND = 59;
    private final int SEC_IN_HOUR = 3600;
    private final int SEC_IN_MINUTE = 60;

    public Time1(int h, int m, int s) {
        this._hour = 0;
        if (h >= 0 && h <= 23) {
            this._hour = h;
        }
        this._minute = 0;
        if (m >= 0 && m <= 59) {
            this._minute = m;
        }
        this._second = 0;
        if (s >= 0 && s <= 59) {
            this._second = s;
        }
    }

    public Time1(Time1 other) {
        this._hour = other._hour;
        this._minute = other._minute;
        this._second = other._second;
    }

    public int getHour() {
        return this._hour;
    }

    public int getMinute() {
        return this._minute;
    }

    public int getSecond() {
        return this._second;
    }

    public void setHour(int num) {
        if (num >= 0 && num <= 23) {
            this._hour = num;
        }
    }

    public void setMinute(int num) {
        if (num >= 0 && num <= 59) {
            this._minute = num;
        }
    }

    public void setSecond(int num) {
        if (num >= 0 && num <= 59) {
            this._second = num;
        }
    }

    public long secFromMidnight() {
        return this._hour * 3600 + this._minute * 60 + this._second;
    }

    public boolean equals(Time1 other) {
        if (other != null && this._hour == other._hour && this._minute == other._minute && this._second == other._second) {
            return true;
        }
        return false;
    }

    public boolean before(Time1 other) {
        if (this._hour > other._hour) {
            return false;
        }
        if (this._hour < other._hour) {
            return true;
        }
        if (this._minute > other._minute) {
            return false;
        }
        if (this._minute < other._minute) {
            return true;
        }
        if (this._second > other._second) {
            return false;
        }
        if (this._second < other._second) {
            return true;
        }
        return false;
    }

    public boolean after(Time1 other) {
        return other.before(this);
    }

    public int difference(Time1 other) {
        return (int)(this.secFromMidnight() - other.secFromMidnight());
    }

    public String toString() {
        String s = "";
        s = this._hour < 10 ? s + "0" + this._hour + ":" : s + this._hour + ":";
        s = this._minute < 10 ? s + "0" + this._minute + ":" : s + this._minute + ":";
        s = this._second < 10 ? s + "0" + this._second : s + this._second;
        return s;
    }
}
