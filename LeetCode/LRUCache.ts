// To execute: ts-node LRUCache.ts
class Nodo {
    key: string;
    value: number;
    left?: Nodo;
    right?: Nodo;

    constructor(key: string, value: number) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    elements: {[key: string]: Nodo};
    start?: Nodo;
    end?: Nodo;
    capacity: number;
    length: number;

    constructor(capacity: number) {
        this.elements = {};
        this.capacity = capacity;
        this.length = 0;
    }

    get(key: number): number {
        if(this.elements[key]) {
            const element: Nodo = this.elements[key];
            this.moveToFront(element);
            return element.value;;
        } else
            return -1;
    }

    put(keyNumeric: number, value: number): void {
        const key = keyNumeric.toString();
        if(this.elements[key]) {
            this.elements[key].value = value;
            this.moveToFront(this.elements[key]);
        } else {
            const newElement: Nodo = new Nodo(key, value);
            if(!this.start)
                this.start = newElement;
            else if(this.length == this.capacity) {
                const elementToRemove: Nodo = this.end!;
                if(elementToRemove.left)
                    elementToRemove.left.right = newElement;
                newElement.left = elementToRemove.left;
                delete this.elements[elementToRemove.key];
                this.length--;
            } else {
                this.end!.right = newElement;
                newElement.left = this.end;
            }
            this.elements[key] = newElement;
            this.end = newElement;
            this.length++;
            this.moveToFront(newElement);
        }
    }

    toString(): string {
        return this.recursiveToString(this.start);
    }

    private recursiveToString(node?: Nodo): string {
        if(node != undefined) {
            console.log(node);
            return `${node.value}, ` + this.recursiveToString(node.right);
        } else
            console.log("##########");
            return "\n";
    }

    moveToFront(node: Nodo): void {
        if(this.length < 2)
            return;
        if(node.left) {
            node.left.right = node.right;
            if(node.right)
                node.right.left = node.left;
        }
        if(node === this.end)
            this.end = node.left;
        this.end!.right = undefined;
        if(this.start != node) {
            node.right = this.start;
            this.start!.left = node;
        }
        this.start = node;
        this.start!.left = undefined;
    }
    
}