import sys
from tkinter import filedialog
from PyQt5.QtWidgets import (QWidget, QLabel,
                             QComboBox, QApplication,QFileDialog,QPushButton) 
class Example(QWidget):
    def __init__(self):
        super().__init__()
        self.initUI()
 
    def initUI(self):
        self.lbl = QLabel("Ubuntu", self)
        self.lbl.move(50, 150)
        
        # combo = QComboBox(self)
        # combo.addItem("Ubuntu")
        # combo.addItem("Mandriva")
        # combo.addItem("Fedora")
        # combo.addItem("Arch")
        # combo.addItem("Gentoo")
        # combo.move(50, 50)
        # combo.activated[str].connect(self.onActivated)
        
        # fileNameLabel = QLabel('testLabel',self)
        # fileNameLabel.move(0, 50)
        
        self.fileButton = QPushButton('select file',self)
        self.fileButton.move(10,10)
        
        self.setGeometry(300, 300, 800, 600)
        self.setWindowTitle('QComboBox')
        self.show()
 
    def onActivated(self, text):
        self.lbl.setText(text)
        self.lbl.adjustSize()
    
    
        