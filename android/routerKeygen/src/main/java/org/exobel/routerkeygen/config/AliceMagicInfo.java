/*
 * Copyright 2012 Rui Araújo, Luís Fonseca
 *
 * This file is part of Router Keygen.
 *
 * Router Keygen is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Router Keygen is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Router Keygen.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.exobel.routerkeygen.config;

import android.os.Parcel;
import android.os.Parcelable;

public class AliceMagicInfo implements Parcelable {
    public static final Parcelable.Creator<AliceMagicInfo> CREATOR = new Parcelable.Creator<AliceMagicInfo>() {
        public AliceMagicInfo createFromParcel(Parcel in) {
            return new AliceMagicInfo(in);
        }

        public AliceMagicInfo[] newArray(int size) {
            return new AliceMagicInfo[size];
        }
    };
    final private String alice;
    final private int[] magic;
    final private String serial;
    final private String mac;

    public AliceMagicInfo(String alice, int[] magic, String serial, String mac) {
        this.alice = alice;
        this.magic = magic;
        this.serial = serial;
        this.mac = mac;
    }

    private AliceMagicInfo(Parcel in) {
        this.alice = in.readString();
        this.serial = in.readString();
        this.mac = in.readString();
        this.magic = in.createIntArray();
    }

    public String getAlice() {
        return alice;
    }

    public int[] getMagic() {
        return magic;
    }

    public String getSerial() {
        return serial;
    }

    public String getMac() {
        return mac;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(alice);
        dest.writeString(serial);
        dest.writeString(mac);
        dest.writeIntArray(magic);
    }

}
