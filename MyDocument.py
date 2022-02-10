from win32com.client import Dispatch
class MyDocumentConfig:
    def __init__(self, documentFileName, range, fromPage, toPage):
        self.documentFileName = documentFileName
        self.copies = 1
        self.range = range
        self.fromPage = fromPage
        self.toPage = toPage
        
    def setFromPage(fromPage):
        print(fromPage)
        
        