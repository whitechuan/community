## 白蚁社区

## 资料
[spring 文档](https://spring.io)

[spring-web](https://spring.io/guides/gs/serving-web-content/)

[模仿社区网站](https://elasticsearch.cn)

[github Creating a GitHub App](https://developer.github.com/apps/building-github-apps/creating-a-github-app/)
## 工具
git

## git 命令
 追加   git commit --amend --no-edit
### 报错
    hint: Updates were rejected because the remote contains work that you do
    hint: not have locally. This is usually caused by another repository pushing
    hint: to the same ref. You may want to first integrate the remote changes
    hint: (e.g., 'git pull ...') before pushing again.
    hint: See the 'Note about fast-forwards' in 'git push --help' for details.
     
    出现这个问题是因为远程分支上存在本地分支中不存在的提交,是多人开发中遇到的问题,可以先fetch 再merge,也就是pull,把运程分支上的提交合并到本地分支之后再push.
    如果说远程分支上的那些提交都不需要了,那么用命令:
    git push origin master -f //强行让本地分支覆盖远程分支
    git pull :命令用于从另一个存储库或本地分支获取并集成(整合).作用:取回远程主机某个分支的更新,再与本地的指定分支合并
    
    使用语法:
    git pull [options][<reposit>][<refspec>..]
    git fetch：相当于是从远程获取最新版本到本地，不会自动合并。
    如果还想要远程分支上的提交:
    git新版本的使用旧的pull命令:$ git pull origin master并不会解决问题,需要改为:
    git pull origin master --allow-unrelated-histories

  