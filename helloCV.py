import sys
import cv2

print('Hello, OpenCV',cv2.__version__)

img=cv2.imread('cat.bmp',cv2.IMREAD_GRAYSCALE)

if img is None:
    print('Image load failed')
    sys.exit()

cv2.imwrite('cat_gray.png',img)

cv2.namedWindow('image',cv2.WINDOW_NORMAL)
cv2.imshow('image',img)
cv2.waitKey()#키보드 입력을 기다리고 화면에 보일 수 있게 
cv2.destroyAllWindows() #모든 창 닫기  