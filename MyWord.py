from win32com.client import gencache,Dispatch,constants
import win32print
app = Dispatch('Word.Application')
# app.Visible = False
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
    
mydir = 'C:\\Users\\86442\\Desktop\\TemporaryWork\\'
testFile = mydir+'in.docx'
docs = app.Documents

docs.Open(mydir + 'in.docx')
docs.Open(mydir + 'in2.docx')
print(docs.Count)

myDoc1 = docs.Item(2)
myDoc2 = docs.Item(1)

print(myDoc1.BuiltInDocumentProperties(constants.wdPropertyPages))

app.Visible = False
def printDoc( mystr ):
    app.PrintOut(FileName=mystr, Range= constants.wdPrintAllDocument)
    pass 

# printDoc(testFile)
# print(dir(docs.Item[0].Range))
# print(gencache.__name__)
