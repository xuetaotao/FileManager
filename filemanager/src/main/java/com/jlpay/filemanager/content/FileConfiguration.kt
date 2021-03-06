package com.jlpay.filemanager.content

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

/**
 * 配置信息
 *
 * 1.3.0 主要更新信息：
 * 1) Android 11 12 支持，完善 WPS 文件类型
 * 2) 新增 [titleGravity] [keepDuplicate] 配置
 * 3) 删除文件崩溃、解压缩中文乱码问题修复
 * 4) [FileVideoPlayer] internal ---> open, FileAsyncImpl 重命名为 [FileStipulateAsync]
 */
class FileConfiguration : Serializable {

    companion object {
        /** QQ目录 */
        const val QQ = "FILE_QQ_FILE_PATH"

        /** 微信目录 */
        const val WECHAT = "FILE_WECHAT_FILE_PATH"

        /** 默认 */
        const val BY_DEFAULT = 0x1000

        /** 根据名字 */
        const val BY_NAME = 0x1001

        /** 根据最后修改时间 */
        const val BY_DATE = 0x1003

        /** 根据大小 */
        const val BY_SIZE = 0x1004

        /** 升序 */
        const val ASC = 0x2001

        /** 降序 */
        const val DESC = 0x2002

        /** 样式一 */
        const val STYLE1 = 1

        /** 样式二 */
        const val STYLE2 = 2

        const val RENAME = "重命名"
        const val COPY = "复制"
        const val MOVE = "移动"
        const val DELETE = "删除"
        const val INFO = "查看详情"

        /** 标题居左 */
        const val TITLE_LEFT = 0

        /** 标题居中 */
        const val TITLE_CENTER = 1

        /** 标题居右 */
        @Deprecated("")
        const val TITLE_RIGHT = 2
    }

    /**
     * 起始访问位置，空为 SD卡根目录
     * 还可指定QQ或微信目录 see [QQ] [WECHAT]
     */
    var filePath: String? = null

    /**
     * 打开QQ或微信目录 see [QQ] [WECHAT]
     * 下一个版本
     */
    var qwType: String? = null

    /**
     * 图片资源配置
     */
    var resources = FileResources()

    /**
     * 是否显示隐藏文件
     */
    var showHiddenFile = false

    /**
     * 根据什么排序 see [BY_DEFAULT] [BY_NAME] [BY_DATE] [BY_SIZE]
     */
    var sortordBy = BY_DEFAULT

    /**
     * 排序方式 see [ASC] [DESC]
     */
    var sortord = ASC

    /**
     * 过滤规则，默认显示所有的文件类型
     * 如 arrayOf(PNG, JPG, JPEG, GIF) 只显示图片类型
     */
    var fileFilterArray: Array<String>? = null

    /**
     * 文件选取大小的限制，单位：M
     */
    var maxSize = 10

    /**
     * 超过最大选择大小文字提醒
     */
    var maxSizeStr = "您只能选取小于${maxSize}M的文件"

    /**
     * 最大选取数量
     */
    var maxLength = 9

    /**
     * 超过最大选择数量文字提醒
     */
    var maxLengthStr = "您最多可以选取${maxLength}个文件"

    /**
     * 选中的样式 see [STYLE1] [STYLE2]
     */
    var boxStyle = STYLE2

    /**
     * 是否需要长按事件
     */
    var needLongClick = true

    /**
     * 默认只有文件才有长按事件
     * 长按暂不支持对于文件夹的操作，如有需要，请实现 FileOperateListener
     */
    var isOnlyFileHasLongClick = true

    /**
     * 长按后需要显示的操作类型 see [RENAME] [COPY] [MOVE] [DELETE] [INFO]
     * 空默认为 arrayOf(RENAME, COPY, MOVE, DELETE, INFO)
     * 目前只可以是这几种类型，个数、顺序可以自定义，文字不支持自定义
     */
    var longClickOperateTitles: Array<String>? = null

    /**
     * 是否只需要显示文件夹
     */
    var isOnlyFolder = false

    /**
     * 是否只需要显示文件
     */
    var isOnlyFile = false

    /**
     * 打开文件需要 FileProvider 一般都是包名 + xxxFileProvider
     * 如果项目中已经存在或其他原因无法修改，请自己实现 FileOpenListener
     */
    var authority = ""

    /**
     * 是否需要显示 已选择的文件个数 提示
     */
    var showSelectedCountHint = false

    /**
     * 标题位置 see [TITLE_LEFT] [TITLE_CENTER]
     * 设置标题 重写 [R.string.file_title] 即可
     */
    var titleGravity = TITLE_LEFT
        set(value) {
            if (value in TITLE_LEFT..TITLE_RIGHT) {
                field = value
            } else {
                throwError("titleGravity")
            }
        }

    /**
     * 复制、移动、重命名、解压缩 操作 如果存在相同的文件时 是否需要保留副本
     * false：默认直接覆盖或者移除； true：表示保留原文件，同时新增副本文件
     */
    var keepDuplicate = false

    /**
     * 是否显示日志
     */
    var showLog = true

    /**
     * 方便java同学调用
     */
    class Build {
        private var filePath: String? = null
        private var resources = FileResources()
        private var showHiddenFile = false
        private var sortordBy = BY_DEFAULT
        private var sortord = ASC
        private var fileFilterArray: Array<String>? = null
        private var maxSize = 10
        private var maxSizeStr = "您只能选取小于${maxSize}M的文件"
        private var maxLength = 9
        private var maxLengthStr = "您最多可以选取${maxLength}个文件"
        private var boxStyle = STYLE1
        private var needLongClick = true
        private var isOnlyFileHasLongClick = true
        private var longClickOperateTitles: Array<String>? = null
        private var isOnlyFolder = false
        private var isOnlyFile = false
        private var authority = ""
        private var showSelectedCountHint = false
        private var titleGravity = TITLE_LEFT
        private var keepDuplicate = false
        private var showLog = true

        fun filePath(filePath: String?): Build {
            this.filePath = filePath
            return this
        }

        fun resources(resources: FileResources): Build {
            this.resources = resources
            return this
        }

        fun showHiddenFile(showHiddenFile: Boolean): Build {
            this.showHiddenFile = showHiddenFile
            return this
        }

        fun sortordBy(sortordBy: Int): Build {
            this.sortordBy = sortordBy
            return this
        }

        fun sortord(sortord: Int): Build {
            this.sortord = sortord
            return this
        }

        fun fileFilterArray(fileFilterArray: Array<String>?): Build {
            this.fileFilterArray = fileFilterArray
            return this
        }

        fun maxSize(maxSize: Int): Build {
            this.maxSize = maxSize
            return this
        }

        fun maxSizeStr(maxSizeStr: String): Build {
            this.maxSizeStr = maxSizeStr
            return this
        }

        fun maxLength(maxLength: Int): Build {
            this.maxLength = maxLength
            return this
        }

        fun maxLengthStr(maxLengthStr: String): Build {
            this.maxLengthStr = maxLengthStr
            return this
        }

        fun boxStyle(boxStyle: Int): Build {
            this.boxStyle = boxStyle
            return this
        }

        fun needLongClick(needLongClick: Boolean): Build {
            this.needLongClick = needLongClick
            return this
        }

        fun isOnlyFileHasLongClick(isOnlyFileHasLongClick: Boolean): Build {
            this.isOnlyFileHasLongClick = isOnlyFileHasLongClick
            return this
        }

        fun longClickOperateTitles(longClickOperateTitles: Array<String>?): Build {
            this.longClickOperateTitles = longClickOperateTitles
            return this
        }

        fun isOnlyFolder(isOnlyFolder: Boolean): Build {
            this.isOnlyFolder = isOnlyFolder
            return this
        }

        fun isOnlyFile(isOnlyFile: Boolean): Build {
            this.isOnlyFile = isOnlyFile
            return this
        }

        fun authority(authority: String): Build {
            this.authority = authority
            return this
        }

        fun showSelectedCountHint(showSelectedCountHint: Boolean): Build {
            this.showSelectedCountHint = showSelectedCountHint
            return this
        }

        fun titleGravity(titleGravity: Int): Build {
            if (titleGravity in TITLE_LEFT..TITLE_RIGHT) {
                this.titleGravity = titleGravity
            } else {
                throwError("boxStyle")
            }
            return this
        }

        fun keepDuplicate(keepDuplicate: Boolean): Build {
            this.keepDuplicate = keepDuplicate
            return this
        }

        fun showLog(showLog: Boolean): Build {
            this.showLog = showLog
            return this
        }

        fun build() = FileConfiguration().apply {
            this.filePath = this@Build.filePath
            this.resources = this@Build.resources
            this.showHiddenFile = this@Build.showHiddenFile
            this.sortordBy = this@Build.sortordBy
            this.sortord = this@Build.sortord
            this.fileFilterArray = this@Build.fileFilterArray
            this.maxSize = this@Build.maxSize
            this.maxSizeStr = this@Build.maxSizeStr
            this.maxLength = this@Build.maxLength
            this.maxLengthStr = this@Build.maxLengthStr
            this.boxStyle = this@Build.boxStyle
            this.needLongClick = this@Build.needLongClick
            this.isOnlyFileHasLongClick = this@Build.isOnlyFileHasLongClick
            this.longClickOperateTitles = this@Build.longClickOperateTitles
            this.isOnlyFolder = this@Build.isOnlyFolder
            this.isOnlyFile = this@Build.isOnlyFile
            this.authority = this@Build.authority
            this.showSelectedCountHint = this@Build.showSelectedCountHint
            this.titleGravity = this@Build.titleGravity
            this.keepDuplicate = this@Build.keepDuplicate
            this.showLog = this@Build.showLog
        }

    }


    /**
     * 图片相关资源配置 设置 [FILE_DEFAULT] 将使用默认资源 各种文件类型的图片 建议 128 * 128
     * @property audioRes Int        音频
     * @property txtRes Int          文本
     * @property pdfRes Int          PDF
     * @property pptRes Int          PPT
     * @property wordRes Int         Word
     * @property excelRes Int        Excel
     * @property zipRes Int          ZIP
     * @property otherRes Int        其他类型
     * @property emptyRes Int        空资源
     * @property folderRes Int       文件夹
     * @property lineColor Int       列表分割线颜色
     */
    data class FileResources @JvmOverloads constructor(
        var audioRes: Int = FILE_DEFAULT,
        var txtRes: Int = FILE_DEFAULT,
        var pdfRes: Int = FILE_DEFAULT,
        var pptRes: Int = FILE_DEFAULT,
        var wordRes: Int = FILE_DEFAULT,
        var excelRes: Int = FILE_DEFAULT,
        var zipRes: Int = FILE_DEFAULT,
        var otherRes: Int = FILE_DEFAULT,
        var emptyRes: Int = FILE_DEFAULT,
        var folderRes: Int = FILE_DEFAULT,
        var lineColor: Int = FILE_DEFAULT
    ) : Serializable, Parcelable {

        constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(audioRes)
            parcel.writeInt(txtRes)
            parcel.writeInt(pdfRes)
            parcel.writeInt(pptRes)
            parcel.writeInt(wordRes)
            parcel.writeInt(excelRes)
            parcel.writeInt(zipRes)
            parcel.writeInt(otherRes)
            parcel.writeInt(emptyRes)
            parcel.writeInt(folderRes)
            parcel.writeInt(lineColor)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<FileResources> {
            override fun createFromParcel(parcel: Parcel): FileResources {
                return FileResources(parcel)
            }

            override fun newArray(size: Int): Array<FileResources?> {
                return arrayOfNulls(size)
            }
        }
    }
}