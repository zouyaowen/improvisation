# improvisation
SpringBoot Learning



## GIT学习

```shell
#查看当前状态及提交代码
git status
git add
git commit -m '当前代码提交注释'
git push
git commit -am 'message' -am等同于-a -m 
#-a参数可以将所有已跟踪文件中的执行修改或删除操作的文件都提交到本地仓库，即使它们没有经过git add添加到暂存区，

#创建分支并将分支提交到远程服务器
git branch develop
#创建并切换到新创建的分支
#git checkout -b develop
#切换分支
git checkout develop
#将本地分支上传为到远端
git push origin develop

#?
git submodule init；
git submodule update

#删除本地分支
git branch branchA
git push origin branchA
git branch -d branchA
#删除远程分支
git push origin -d branchA

#要合并其他分支到你的当前分支
git merge <branch>
#在合并改动之前，你可以使用如下命令预览差异
git diff <source_branch> <target_branch>
```

