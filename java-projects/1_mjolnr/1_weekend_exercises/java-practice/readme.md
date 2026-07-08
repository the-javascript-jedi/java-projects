git check-ignore -v .idea      
git check-ignore -v out        
git ls-files | findstr /i ".idea"
git rm -r --cached .idea        
git status       