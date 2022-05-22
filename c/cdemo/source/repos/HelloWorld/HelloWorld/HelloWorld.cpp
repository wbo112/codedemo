// HelloWorld.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
using namespace std;

struct mya {
    int num;
    char str[10];
    struct mya* next;


} ab;
class Grade {
public:
    Grade(int ab);
    void p() {
        cout << a << endl;
    }
private:
    int a;
};
Grade::Grade(int ab) :a{ ab } {

}
class Parson:public Grade {
public:
    Parson(int a) :Grade{ a } {

    }

};
class P1 {
public:
    P1() {
        cout << "P1" << endl;
    }
};

int main()
{
    printf("%d\n", ab.num);
    struct mya a;
    struct mya* a1 = NULL;
    printf("%p\n", &a1);
    printf("%s\n", a.str);
    printf("%d\n", a.num);
    cout << "==================" << endl;
    Parson parson{ 10 };
    parson.p();
    cout << "==================" << endl;
    P1 p1;
    P1 p2{};
    cout << "==================" << endl;
    void* ptr = malloc(4 + sizeof(struct mya));
    memset(ptr, 0, 4 + sizeof(struct mya));
    int m_maxNode = 10;
    memcpy(ptr, &m_maxNode, sizeof(int));

    a.num = 12;
    char  ab[10]="abcdefg";
    memcpy(&a.str, "abcdefg", sizeof("abcdefg"));
    cout << "a.str =="<<a.str << endl;
    memcpy((char *)ptr+4, &a, sizeof(struct mya));
    int m;
    memcpy(&m, ptr, sizeof(int));
    cout << " m =" << m << endl;
    struct mya a11;
    memcpy(&a11, (char*)ptr + 4, sizeof(struct mya));
    cout << "a11.str = " << a11.str << endl;
    std::cout << "Hello World!\n";
}

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门使用技巧: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
