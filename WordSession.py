from win32com.client import gencache,Dispatch,constants
import win32print
import MyDocument
from MyDocument import MyDocument
app = gencache.Dispatch('Word.Application')

printers = []
fileNames = []


    
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

def printDoc( myDocument ):
    app.PrintOut(FileName = myDocument.fileName, Range= constants.wdPrintAllDocument)

def getPagesCount(document ):
    return document.BuiltInDocumentProperties(constants.wdPropertyPages)

def setDocument(documentFileName):
    
    myDocument = MyDocument()
def getAlternativePrinter():
    for it in win32print.EnumPrinters(2):
        printers.append(it[2])
# printDoc(testFile)
# print(dir(docs.Item[0].Range))
# print(gencache.__name__)
