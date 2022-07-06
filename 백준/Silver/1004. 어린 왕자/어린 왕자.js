const line = require("fs").readFileSync("/dev/stdin", "utf8");
let input = line.trim().split("\n");

const testCase = parseInt(input[0]);
let n = 0;


for (let testcaseData = 0; testcaseData < testCase; testcaseData++) { // 테스트케이스 루프
    let Count = 0;
    
    let planetAmout = parseInt(input[n + 2]);
    let The_Little_Prince_locate = input[ n + 1 ].split(" ");
    const planet = [];

    for (let i = 0; i < planetAmout; i++) {
        planet.push(input[n + i + 3]);
    }


    const [prins_x1, prins_y1, prins_x2, prins_y2] = The_Little_Prince_locate; // 출발지점과 도착지점 저장

    for (let x = 0; x < planetAmout; x++) {
        const [cx, cy, gap] = planet[x].split(" ");

        dis1 = (parseInt(prins_x1) - parseInt(cx)) ** 2 + (parseInt(prins_y1) - parseInt(cy)) ** 2; // 행성과 시작지점 어린왕자의 거리
        dis2 = (parseInt(prins_x2) - parseInt(cx)) ** 2 + (parseInt(prins_y2) - parseInt(cy)) ** 2; // 행성과 끝지점 어린왕자의 거리

        gapdis = parseInt(gap) ** 2; // 기준점 거리

        if (dis1 < gapdis && dis2 < gapdis) {
            continue;
        }
        if (dis1 < gapdis) {
            Count ++;
        } 
        if (dis2 < gapdis) {
            Count ++;
        }
    }
    console.log(Count);
    
    n += planetAmout + 2;
}