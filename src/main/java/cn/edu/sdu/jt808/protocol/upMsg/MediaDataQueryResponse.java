package cn.edu.sdu.jt808.protocol.upMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

import java.util.List;

@MsgType(MessageId.msg_id_saved_media_response)
public class MediaDataQueryResponse extends PackageData<Header> {

    private Integer replyFlowId;
    private Integer total;
    private List<Item> list;


    @Property(index = 0, type = DataType.WORD, desc = "应答流水号")
    public Integer getReplyFlowId() {
        return replyFlowId;
    }

    public void setReplyFlowId(Integer replyFlowId) {
        this.replyFlowId = replyFlowId;
    }

    @Property(index = 2, type = DataType.WORD, desc = "多媒体数据总项数")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Property(index = 4, type = DataType.LIST, desc = "检索项")
    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    public static class Item {

        private Integer id;
        private Integer type;
        private Integer channelId;
        private Integer event;
        private Location location;

        @Property(index = 0, type = DataType.DWORD, desc = "多媒体数据ID")
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Property(index = 4, type = DataType.BYTE, desc = "多媒体类型 0：图像；1：音频；2：视频")
        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        @Property(index = 5, type = DataType.BYTE, desc = "通道ID")
        public Integer getChannelId() {
            return channelId;
        }

        public void setChannelId(Integer channelId) {
            this.channelId = channelId;
        }

        @Property(index = 6, type = DataType.BYTE, desc = "事件项编码")
        public Integer getEvent() {
            return event;
        }

        public void setEvent(Integer event) {
            this.event = event;
        }

        @Property(index = 7, type = DataType.OBJ, length = 28, desc = "位置信息")
        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }
    }
}