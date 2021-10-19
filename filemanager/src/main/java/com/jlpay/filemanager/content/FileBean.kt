package com.jlpay.filemanager.content

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class FileBean(
    var fileName: String? = "",      // 文件名
    var isFile: Boolean = true,     // true---文件；false---文件夹
    var filePath: String? = "",      // 文件路径
    var date: String? = "",          // 格式化后的时间
    var originalDate: String? = "",  // 原始时间
    var size: String? = "",          // 格式化后的大小
    var originaSize: Long = 0L,     // 原始大小
    var parent: String? = ""
) : Serializable, Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readLong(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fileName)
        parcel.writeByte(if (isFile) 1 else 0)
        parcel.writeString(filePath)
        parcel.writeString(date)
        parcel.writeString(originalDate)
        parcel.writeString(size)
        parcel.writeLong(originaSize)
        parcel.writeString(parent)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FileBean> {
        override fun createFromParcel(parcel: Parcel): FileBean {
            return FileBean(parcel)
        }

        override fun newArray(size: Int): Array<FileBean?> {
            return arrayOfNulls(size)
        }
    }
}

internal data class FileInfoBean(
    var duration: String = "",
    var width: String = "",
    var height: String = ""
)

internal data class FilePathBean(
    var fileName: String = "", // 路径名称
    var filePath: String = "" // 文件路径
)

internal data class FileQWBean(
    var zFileBean: FileBean? = null,
    var isSelected: Boolean = true
)