import sys
import cv2
import numpy as np

# sample image will be a command ine argument
imagepath = sys.argv[1]
haarcascpath="haarcascade_frontlface_default.xml"

faceCascade=cv2.CascadeClassifier(haarcascpath)
img=cv2.imread(imagepath)
grayimg=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
# cv2.imshow("image",grayimg)
# cv2.waitKey(0)
faces = faceCascade.detectMultiScale(
    grayimg,scaleFactor=1.3,minNeighbors=4, minSize=(30, 30), flags = cv2.cv.CV_HAAR_SCALE_IMAGE)
# loop to create rectangles around the ROI 
for (x, y, w, h) in faces:
    cv2.rectangle(img, (x, y), (x+w, y+h), ( 0, 0,255), 2)

cv2.imshow("Faces", img)
cv2.waitKey(0)

