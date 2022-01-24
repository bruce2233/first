from importlib_metadata import sys
from win32com.client import gencache,Dispatch,constants
import win32print
from MyDocument import MyDocumentConfig
import myqt
from PyQt5.QtWidgets import (QWidget, QLabel,QComboBox, QApplication,QFileDialog,QPushButton) 

class MyWindow(myqt.Example):
    def __init__(self):
        super().__init__()
        self.init()
    
    def selectFile(self):
        fileName = QFileDialog.getOpenFileName(self, 'select a word file', 'C:\\Users\\86442\\Desktop\\TemporaryWork', 'word(*.doc *.docx)')
        print(fileName)
        fileNames.append(fileName)
        
    def init(self):
        self.fileButton.clicked.connect(self.selectFile)
def getPagesCount(document ):
    return document.BuiltInDocumentProperties(constants.wdPropertyPages)

def initDocumentConfig(documentFileName):
    docs.Open(documentFileName)
    document = docs.Item(docs.Count)
    toPage = getPagesCount(document)
    myDocument = MyDocumentConfig(documentFileName=documentFileName, range=constants.wdPrintFromTo, fromPage = 1, toPage=toPage)
    myDocs.update({ documentFileName : myDocument})
    
def getAlternativePrinter():
    for it in win32print.EnumPrinters(2):
        printers.append(it[2])

# printDoc(testFile)
# print(dir(docs.Item[0].Range))
# print(gencache.__name__)
print(__name__)
if __name__ == '__main__':
    app = Dispatch('Word.Application')

    printers = []
    fileNames = []
    myDocs = {}

    mydir = 'C:\\Users\\86442\\Desktop\\TemporaryWork\\'
    testFile = mydir+'in.docx'
    docs = app.Documents
    initDocumentConfig(testFile)
    # myDocs[]
    print(myDocs.items())
    myDoc1 = docs.Item(1)
    qtapp = QApplication(sys.argv)
    ui = MyWindow()
    ui.show()
    sys.exit(qtapp.exec_())
    
