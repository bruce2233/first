from win32com.client import Dispatch
import win32print

app = Dispatch('Word.Application')
# 新建word文档
# doc = app.Documents.Add()
# app.Visible = True

# # 运行下句代码后，s获得新建文档的光标焦点，也就是图中的回车符前
# s = app.Selection
# # 用“Hello, World!“替换s代表的范围的文本
# s.Text = 'Hello, world!'
printers = [] 
for it in win32print.EnumPrinters(2):
    # print(it[2])
    printers.append(it[2])
    
testFile = 'C:\\Users\\86442\\Desktop\\TemporaryWork\\'
docs = app.Documents
print(docs.Open(testFile + 'in.docx'))
# print(docs.Activate)
def printDoc( str ):
    print()
