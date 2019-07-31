FROM openjdk:11

# 设定时区
ENV TZ=Asia/Shanghai
RUN set -eux;\
    ln -snf /usr/share/zoneinfo/$TZ /etc/localtime;\
    echo $TZ > /etc/timezone

# 新建用户 jt808
RUN set -eux;\
    addgroup --gid 1000 jt808;\
    adduser --system --uid 1000 -gid 1000 --home=/home/jt808/ --shell=/bin/sh --disabled-password jt808;\
    mkdir -p /home/jt808/data /home/jt808/etc /home/jt808/logs /home/jt808/jt808;\
    chown -R jt808:jt808 /home/jt808

# 导入启动脚本
COPY --chown=jt808:jt808 docker-entrypoint.sh /home/jt808/docker-entrypoint.sh

# 导入配置文件
COPY --chown=jt808:jt808 conf.yml /home/jt808/etc/conf.yml

# 导入代码
COPY --chown=jt808:jt808 /build/libs/jt808-1.0.jar /home/jt808/jt808/jt808-1.0.jar

RUN apt-get install -y unzip

RUN unzip -o /home/jt808/jt808/jt808-1.0.jar > /dev/null

RUN ["chmod", "+x", "/home/jt808/docker-entrypoint.sh"]

USER jt808

ENTRYPOINT ["/home/jt808/docker-entrypoint.sh"]

EXPOSE 6608 10002